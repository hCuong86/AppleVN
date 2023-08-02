package poly.edu.asmjava5.controller.admin;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import poly.edu.asmjava5.domain.Account;
import poly.edu.asmjava5.model.AccountDto;
import poly.edu.asmjava5.service.AccountService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("admin/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("account", new AccountDto());

        return "admin/accounts/addOrEdit";
    }

        @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model,
            @Valid @ModelAttribute("account") AccountDto dto, BindingResult result) {

        if (result.hasErrors()) {
            return new ModelAndView("admin/accounts/addOrEdit");
        }

        Account  entity = new Account(); // tao ra Entity
        BeanUtils.copyProperties(dto, entity); // copy du lieu tu dto sang entity

        accountService.save(entity); // luu vao DB

        model.addAttribute("message", "Account is Seved!");

        return new ModelAndView("forward:/admin/accounts", model);
    }

    @RequestMapping("")
    public String list(ModelMap model) {

        List<Account> list = accountService.findAll();

        model.addAttribute("accounts", list);

        return "admin/accounts/list";
    }

       @GetMapping("edit/{username}")
   public ModelAndView edit(ModelMap model, @PathVariable("username") String username) {

       Optional<Account> opt = accountService.findById(username);

       AccountDto dto = new AccountDto();

       if (opt.isPresent()) {
           Account entity = opt.get();

           BeanUtils.copyProperties(entity, dto);
           dto.setIsEdit(true);

           dto.setPassword("");

           model.addAttribute("account", dto);

           return new ModelAndView("admin/accounts/addOrEdit", model);
       }
       model.addAttribute("message", "account is not existed!");
       return new ModelAndView("forward:/admin/accounts", model);

   }



   @GetMapping("delete/{username}")
   public ModelAndView delete(ModelMap model, @PathVariable("username") String username) {
           accountService.deleteById(username);

           model.addAttribute("message", "Account is deleted!");

       return new ModelAndView("forward:/admin/accounts", model);
   }


//
//
//
//    @GetMapping("search")
//    public String search(ModelMap model,
//    @RequestParam(name ="name", required = false) String name) {
//
//        List<account> list = null;
//
//        if (StringUtils.hasText(name)) {
//            list = accountService.findByNameContaining(name);
//        }else{
//            list = accountService.findAll();
//        }
//        model.addAttribute("accounts", list);
//        return "admin/accounts/search";
//    }
//
//
//     @GetMapping("searchpaginated")
//    public String search(ModelMap model,
//    @RequestParam(name ="name", required = false) String name,
//    @RequestParam("page") Optional<Integer> page,
//    @RequestParam("size") Optional<Integer> size) {
//
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(5);
//
//        Pageable pageable = PageRequest.of(currentPage -1, pageSize, Sort.by("name"));
//
//        Page<account> resultPage = null;
//
//        if (StringUtils.hasText(name)) {
//            resultPage = accountService.findByNameContaining(name, pageable);
//
//            model.addAttribute("name", name);
//        }else{
//            resultPage = accountService.findAll(pageable);
//        }
//        int totalPages = resultPage.getTotalPages();
//        if(totalPages > 0) {
//            int start = Math.max(1, currentPage -2);
//            int end = Math.min (currentPage + 2, totalPages);
//            if (totalPages > 5) {
//                if(end == totalPages) start = end - 5;
//                else if (start == 1) end = start + 5;
//            }
//            List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
//            .boxed()
//            .collect(Collectors.toList());
//
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//        model.addAttribute("accountPage", resultPage);
//        return "admin/accounts/searchpaginated";
//    }
}
