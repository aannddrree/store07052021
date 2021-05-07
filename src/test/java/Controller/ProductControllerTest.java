package Controller;

import br.com.store.Main;
import br.com.store.model.Product;
import br.com.store.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class ProductControllerTest {

    @Autowired
    private ProductService productService;

    @Test
    public void save() throws Exception {

        long qtd = 200;

        productService.deleteAll();

        for ( int i = 1 ; i <= qtd ; i++){
            productService.sendProductRabbit(new Product(i, "teste"+i));
        }

        Thread.sleep(5000);
        List<Product> lst = productService.findAll();

        System.out.println("Qtd:" + lst.size());
        Assert.assertEquals(lst.size(), qtd);
    }

}
