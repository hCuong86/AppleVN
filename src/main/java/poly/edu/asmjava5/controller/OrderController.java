package poly.edu.asmjava5.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import poly.edu.asmjava5.domain.Order;
import poly.edu.asmjava5.domain.OrderDetail;
import poly.edu.asmjava5.domain.Product;
import poly.edu.asmjava5.model.OrderDetailDto;
import poly.edu.asmjava5.model.ProductDto;
import poly.edu.asmjava5.service.CategoryService;
import poly.edu.asmjava5.service.OrderDetailService;
import poly.edu.asmjava5.service.ProductService;
import poly.edu.asmjava5.service.StorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    StorageService storageService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    private HttpSession session;

//    @RequestMapping("giohang")
//    public String bag(ModelMap model){
//        OrderDetailDto dto = new OrderDetailDto();
//
//
//        return "/bag";
//    }
//

    //    @RequestMapping("giohang")
//    public String bag(ModelMap model) {
//        // Lấy thông tin giỏ hàng từ session
//        List<OrderDetailDto> cart = (List<OrderDetailDto>) session.getAttribute("cart");
//        if (cart == null) {
//            // Nếu giỏ hàng chưa tồn tại, tạo mới
//            cart = new ArrayList<>();
//        }
//
//        // Tính toán tổng số lượng và tổng giá trị trong giỏ hàng
//        int totalQuantity = 0;
//        double totalPrice = 0;
//
//        Product product = new Product();
//        double unitPrice = product.getUnitPrice();
//        for (OrderDetailDto item : cart) {
//            totalQuantity += item.getQuantity();
//
//            totalPrice += item.getQuantity() * (product.getUnitPrice());
//        }
//
//        model.addAttribute("cart", cart);
//        model.addAttribute("totalQuantity", totalQuantity);
//        model.addAttribute("totalPrice", totalPrice);
//
//        return "bag";
//    }
    @RequestMapping("gio-hang")
    public String bag(ModelMap model) {

        List<OrderDetail> list = orderDetailService.findAll();

        model.addAttribute("cart-item", list);
        return "/bag";
    }


    @PostMapping("/add-to-cart/{id}")
    public ModelAndView addCart(@PathVariable("id") Long id, ModelMap model){

        Optional<Product> p = productService.findById(id);
        // customer

        if(p.isPresent()){
            System.out.println("san pham ton tai");
            //khai bao order
            //setdate ngay hienj tại
            //set status -> dặt hàng ,....
            //save order
            model.addAttribute("toCart", p.get());
            return new ModelAndView("/bag");
        }else{
            model.addAttribute("toCart", null);
            return new ModelAndView("/bag");
        }
    }
}
