@Controller
class HomeController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!"
    }

}