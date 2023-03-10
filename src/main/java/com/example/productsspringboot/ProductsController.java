package com.example.productsspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductsController {
   public static Products products;
  //  public static ArrayList<Products> productsList = new ArrayList<>();
    public static Map<Integer,Products>productsList =new HashMap<>();

    @GetMapping("/addProducts")
    public String addProductsPage(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "productName", required = false) String productName,
            @RequestParam(name = "quantity", required = false) Integer quantity,
            @RequestParam(name = "price", required = false) Double price,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "isAvailable", required = false) Boolean isAvailable
    ) {
        if (productName != null && !productName.isBlank()
                && quantity != null && price != null
                && description != null && !description.isBlank()
                && isAvailable != null ) {

                productsList.put(id, new Products(id,productName, quantity, price, description, isAvailable));
                //  productsList.add(products = new Products(id,productName, quantity, price, description, isAvailable));
                // System.out.println("adding new product: " + productsList.toString());
                for (Map.Entry<Integer, Products> entry : productsList.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }

        }
        return "addProducts";
    }

    @GetMapping("/viewProducts")
    public String showProducts(Model model) {
        model.addAttribute("listOfAllProducts", productsList.values()); //will transfer list
            return "viewProducts";

}
// get product data to edit them
    @GetMapping("/products/edit/{id}")
    public String editProducts(@PathVariable("id") Integer id,Model model){
        if (id!=null) {
           // model.addAttribute("editProducts", productsList.get(id)); // recognises only as array index not as id!!!
            model.addAttribute("editProducts", productsList.get(id)); // recognises only as array index not as id!!!
        }
        return "updateProducts";
    }
    // to update edited product data
    @PostMapping("/products/edit/{id}")
    public String updateEmployee(@ModelAttribute("editProducts") Products products, @PathVariable("id") Integer id,
                               Model model) {
        model.addAttribute("listOfAllProducts", productsList.put(id, products));
         //   model.addAttribute("listOfAllProducts", productsList.set(id, products));
        return "redirect:/viewProducts";
    }


    // to delete SOME PRODUCT
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Integer id) {
           // model.addAttribute("listOfAllProducts",  productsList.removeIf(products -> id.equals(products.getId())));
        model.addAttribute("listOfAllProducts",  productsList.remove(id));

        return "redirect:/viewProducts";
    }
}
