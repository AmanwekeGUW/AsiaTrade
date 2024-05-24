package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CategoryDTO;
import org.example.dto.ProductDTO;
import org.example.entity.Category;
import org.example.entity.Product;
import org.example.service.LoggedService;
import org.example.service.ProductService;
import org.example.service.CategoryService;

import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService productService;
    private final LoggedService loggedService;
    private final CategoryService categoryService;

    @GetMapping("/index")
    public String Home(@RequestParam(required = false) String logout, Model model) {
        if(logout != null) {
            loggedService.setUserEmail(null);
            return "redirect:/login";
        }
        String userEmail = loggedService.getUserEmail();
        if (userEmail == null) {
            return "redirect:/login";
        }
        model.addAttribute("userEmail", userEmail);
        return "start";
    }

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public String getAllProduct(Model model) {
        List<Product> productsList = productService.getAllProduct();
        model.addAttribute("products", productsList);
        return "card";
    }
    @RequestMapping(value = "/productadd",method = RequestMethod.GET)
    public String ShowProduct(){
        return "product";
    }
//    @RequestMapping(value = "/productadd",method = RequestMethod.POST)
//    public String addProduct(@RequestParam("productName") String name,@RequestParam("catid") Long id,@RequestParam("price") Double price, Model model) {
//        String result = productService.addProduct(name,id,price);
//        if (result.equals("ADDED")) {
//            return "redirect:/index";
//        } else {
//            model.addAttribute("error", "error");
//            return "product";
//        }
//    }
    @RequestMapping(value = "/categoryadd",method = RequestMethod.GET)
    public String show(){
        return "category";
    }
//    @RequestMapping(value = "/categoryadd",method = RequestMethod.POST)
//    public String addCategory(@RequestParam("id") Long id,@RequestParam("categoryName") String CatName,Model model) {
//        String result= categoryService.addCategory(id,CatName);
//        if (result.equals("ADDED")) {
//            return "redirect:/index";
//        } else {
//            model.addAttribute("error", "error");
//            return "category";
//        }
//    }
    @CrossOrigin
    @RequestMapping(value = "/category",method = RequestMethod.GET)
    public String getAllCategory(Model model) {
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categor", categoryList);
        return "index";
    }
}