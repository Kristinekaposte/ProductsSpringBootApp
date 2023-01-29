package com.example.productsspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ProductsController {
    static Products products;
    public static ArrayList<Products> productsList = new ArrayList<>();

    @GetMapping("/addProducts")
    public String addProductsPage(
            @RequestParam(name = "productName", required = false) String productName,
            @RequestParam(name = "quantity", required = false) Integer quantity,
            @RequestParam(name = "price", required = false) Double price,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "isAvailable", required = false) Boolean isAvailable
    ) {
        if (productName != null && !productName.isBlank()
                && quantity != null && price != null
                && description != null && !description.isBlank()
                && isAvailable != null
        ) {
            productsList.add(products = new Products(productName, quantity, price, description, isAvailable));
            System.out.println("adding new product: " + productsList.toString());
        }


        return "addProducts";
    }

    @GetMapping("/viewProducts")
    //  @RequestMapping(value = "/viewProducts",method = RequestMethod.GET)
    public String showProducts(
            @RequestParam(name = "id", required = false) String id,
            @RequestParam(name = "productName", required = false) String productName,
            @RequestParam(name = "quantity", required = false) Integer quantity,
            @RequestParam(name = "price", required = false) Double price,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "isAvailable", required = false) Boolean isAvailable,
            @RequestParam(name = "number", required = false) String number,
            Model model
    ) {
        //VIEW
        model.addAttribute("listOfAllProducts", productsList); //will transfer list
        //UPDATE
        if (id != null && !id.isBlank()) {
            productsList.set(Integer.parseInt(id), new Products(productName, quantity, price, description, isAvailable));
          //  System.out.println("products after update: " + productsList.toString());
        }
        //DELETE
//        if (number != null && !number.isBlank()) {
//            productsList.remove(Integer.parseInt(number));
//            System.out.println("products list after deleting: " + productsList.toString());
//        }
            return "viewProducts";

}

//    @GetMapping("/updateProducts")
//    public String UpdateProducts(@RequestParam(name="id", required = false) String id,
//                                 @RequestParam(name="productName", required = false) String productName,
//                                 @RequestParam(name="quantity", required = false) Integer quantity,
//                                 @RequestParam(name="price", required = false) Double price,
//                                 @RequestParam(name="description", required = false) String description,
//                                 @RequestParam(name="isAvailable", required = false) Boolean isAvailable
//    ){
//        if (id!=null){
//            productsList.set(Integer.parseInt(id), new Products(productName,quantity,price,description,isAvailable));
//            System.out.println("products after update: " + productsList.toString());
//        }
//        return "updateProducts";
//    }

  // @RequestMapping(value="/viewProducts",method = RequestMethod.POST)
  @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value="number", required = false) String number){
        if (number!=null){
            productsList.remove(Integer.parseInt(number));
            System.out.println("products list after deleting: " + productsList.toString());
           // System.out.println("adding number to delete: " +number);
          //  System.out.println("new pets list in delete section: " + productsList);
         //   return "redirect:viewProducts";
        }
        return "deleteProduct";
    }

}
