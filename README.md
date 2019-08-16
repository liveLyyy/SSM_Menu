[JSP九大内置对象和四大作用域](https://blog.csdn.net/m2606707610/article/details/89606856)
=========================
1、request：类型HttpSevlerRequest；封装所有请求信息；获取方式方法参数<br>
2、response：类型HttpSevlerResponse；封装响应信息；获取方式方法参数<br>
3、session：类型HttpSession；封装所有会话；req.getSession()<br>
4、application：类型SerletContext；所有信息;getServletContext();request.getServletContext()<br>
5、out:类型PrintWriter；输出对象；response.getWriter()<br>
6、exception：类型Exception；异常对象<br>
7、page：类型Object；当前页面对象<br>
8、pageContext:类型PageContext；获取其他信息<br>
9、config：类型ServletConfig；配置信息<br>

四大作用域
=========
1、page当前页面不会重新实例化<br>
2、request:在一次请求中同一个对象，下次请求重新实例化一个request对象<br>
3、session:一次会话，只要客户端cookie中传递的jsessionid不变，session不会重新实例化（补偿默认时间）；实际有效时间：浏览器关闭，cookie失效，默认时间，在时间范围内无任何交互，在Tomcat的web.xml中修改<br>
4、application:只有Tomcat启动项目是才实例化，关闭Tomcat时销毁<br>

5、作用域传值的几种方式<br>
>5.1、使用原生Servlet:在HandlerMethod参数中添加作用域对象<br>
```java
@Controller
public class MenuController {
    @Resource
    private MenuService menuServiceImpl;
       @RequestMapping("demo1")
       public String demo1(HttpServletRequest abc,HttpSession sessionParam){
           //request 作用域
           abc.setAttribute("req", "req 的值");
           //session 作用域
           HttpSession session = abc.getSession();
           session.setAttribute("session", "session 的值");
           sessionParam.setAttribute("sessionParam","sessionParam 的值");
           //appliaction 作用域
           ServletContext application = abc.getServletContext();
           application.setAttribute("application","application 的值");
           return "/index.jsp";
      }
}
```
>5.2、使用Map集合:把 map 中内容放在 request 作用域中，spring 会对 map 集合通过 BindingAwareModelMap 进行实例化<br>
```java
@Controller
public class MenuController {
    @Resource
    private MenuService menuServiceImpl;
  
    @RequestMapping("demo2")
        public String demo2(Map<String,Object> map){
            System.out.println(map.getClass());
            map.put("map","map 的值");
            return "/index.jsp";
        }
}
```
>5.3、使用 SpringMVC 中 Model 接口,把内容最终放入到 request 作用域中<br>
```java
@Controller
public class MenuController {
        @Resource
        private MenuService menuServiceImpl;
      
        @RequestMapping("demo3")
            public String demo3(Model model){
                model.addAttribute("model", "model 的值");
                return "/index.jsp";
        }
}
```
>5.4、使用 SpringMVC 中 ModelAndView 类<br>
```java
@Controller
public class MenuController {
        @Resource
        private MenuService menuServiceImpl;
        @RequestMapping("demo4")
        public ModelAndView demo4(){
            //参数,跳转视图
            ModelAndView mav = new ModelAndView("/index.jsp");
            mav.addObject("mav", "mav 的值");
            return mav;
        }
}
```
