package kiteshop.daos;

import kiteshop.pojos.Product;

public interface ProductDAOInterface {

	void createProduct(Product product);
        
        void readProduct(Product product);
        
        void updateProduct(Product product);
        
        void deleteProduct(Product product);
        

}