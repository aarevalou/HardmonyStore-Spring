package com.ufro.harmonystore.services;
import com.ufro.harmonystore.models.ProductDetail;
import com.ufro.harmonystore.repository.pedidos.ProductDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    ProductDetailRepository productDetailRepository;

    //CRUD
    public List<ProductDetail> getAllDetallePedido(){
        return productDetailRepository.findAll();
    }

    public void saveDetallePedido(ProductDetail productDetail){
        productDetailRepository.save(productDetail);
    }

    public void deleteOrderDetails(int id) {
        productDetailRepository.deleteById(id);
    }

    public void updateOrderDetails(ProductDetail productDetail){
        saveDetallePedido(productDetail);
    }
}
