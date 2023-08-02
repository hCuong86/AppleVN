package poly.edu.asmjava5.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import poly.edu.asmjava5.domain.OrderDetail;
import poly.edu.asmjava5.domain.Product;
import poly.edu.asmjava5.service.ProductService;
import poly.edu.asmjava5.service.StorageService;


@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private HttpSession session;


    @RequestMapping("home")
    public String homeController(ModelMap model){
        
        List<Product> list = productService.findAll();

        model.addAttribute("products", list);
        return "/home";
    }
    @RequestMapping("sanpham")
    public String products(ModelMap model){
        
        List<Product> list = productService.findAll();

        model.addAttribute("products", list);
        return "/pricing";
    }


        @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> serverFile(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @RequestMapping("/giohang")
    public String bag(ModelMap model) {
        return "/bag";
    }
}
