package com.example.managerapp.controller;

import com.example.managerapp.controller.payload.NewProductPayload;
import com.example.managerapp.entity.Product;
import com.example.managerapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalog/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/list")
    public String getProductsList(Model model){
        model.addAttribute("products",this.productService.findAllProducts());
        return "catalog/products/list";
    }

    @GetMapping("/create1")
    public String getNewProductPage(){
        return "catalog/products/new_product";
    }

    @PostMapping("/create")
    public String createProduct(NewProductPayload payload){
        Product product = this.productService.createProduct(payload.title(), payload.details());
        return "redirect:/catalog/products/list";
    }
}
