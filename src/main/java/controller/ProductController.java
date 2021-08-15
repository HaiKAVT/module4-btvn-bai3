package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;
@Controller
public class ProductController {
    ProductService productService = new ProductService();

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list",productService.list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create", "categories", productService.categories);
        modelAndView.addObject("list", new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public String  create(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/home";
    }
    @GetMapping("/edit{index}")
    public ModelAndView showEdit(@PathVariable int index, Model model){
        ModelAndView modelAndView = new ModelAndView("edit", "categories", productService.categories);
        modelAndView.addObject("list", productService.list.get(index));
        return modelAndView;
    }
    @PostMapping("/edit{index}")
    public ModelAndView edit(@PathVariable int index, Product product){
        productService.edit(index,product);
        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/home";
    }
}
