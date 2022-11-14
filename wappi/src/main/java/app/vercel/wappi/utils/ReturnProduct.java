package app.vercel.wappi.utils;

import app.vercel.wappi.models.Product;
import app.vercel.wappi.tasks.AddProduct;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReturnProduct {

    private ReturnProduct() {
    }

    public static Product info(List<String> list){
        Logger logger = Logger.getLogger(AddProduct.class.getName());

        logger.log(Level.INFO, () -> "Product info added to model");

        return new Product(
               list.get(0),
               list.get(1),
               list.get(2),
               list.get(3),
               list.get(4),
               list.get(5)
       );

   }
}
