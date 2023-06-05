package ra.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.ra.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController {
    @GetMapping("/")
    public String createCustomer(Model model){
        List<Customer> list = new ArrayList<>();
        list.add(new Customer(1, "Quân", 18));
        list.add(new Customer(2, "Khiết", 28));
        list.add(new Customer(3, "Hùng", 38));
        model.addAttribute("customer",list);
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id,@ModelAttribute("customer") List<Customer> customers){
        customers.remove(id);
        return "redirect:/";
    }
}
