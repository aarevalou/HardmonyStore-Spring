package com.ufro.harmonystore.services;

import com.ufro.harmonystore.models.product.Brand;
import com.ufro.harmonystore.models.product.Category;
import com.ufro.harmonystore.models.product.Product;
import com.ufro.harmonystore.repository.productos.BrandRepository;
import com.ufro.harmonystore.repository.productos.CategoryRepository;
import com.ufro.harmonystore.repository.productos.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    final private ProductRepository productRepository;
    final private BrandRepository branchRepository;
    final private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, BrandRepository branchRepository, CategoryRepository categoriaRepository) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
        this.categoryRepository = categoriaRepository;
    }

    public void createProduct(HashMap<String, String> atributos){
        Product producto = (Product) ObjectService.buildObject(new Product(), atributos);
        saveProducto(producto);
    }

    public Product getProductById(int id){
        List<Product> productoList = getProducts();
        Product producto = productoList.get(id-1);
        return producto;
    }

    public List<Product> getProductsByBrands(int marca_id){
        List<Product> productoList = new ArrayList<>();
        for (Product producto : getProducts()){
            if(producto.getMarca_id() == marca_id){
                productoList.add(producto);
            }
        }
        return productoList;
    }

    public List<Product> getProductsByCategory(int categoria_id){
        List<Product> productoList = getProducts();
        List<Product> productos = new ArrayList<>();

        for (Product producto : productoList){
            if(producto.getCategoria_id() == categoria_id){
                productos.add(producto);
            }
        }
        return productos;
    }

    public List<Product> getProductsByBrands(int minimo, int maximo){
        List<Product> productoList = getProducts();
        return productoList.stream()
                .filter(producto -> {
                    int marca = producto.getMarca_id();
                    return marca >= minimo && marca <= maximo;
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Product> getProductsByPrice(int minimo, int maximo){
        List<Product> productoList = getProducts();
        return productoList.stream()
                .filter(producto -> {
                    int precio = producto.getPrecio();
                    return precio >= minimo && precio <= maximo;
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Product> orderProductsByPrice(Boolean ascendente) {
        List<Product> productoList = getProducts();
        Comparator<Product> comparadorPrecio = Comparator.comparing(Product::getPrecio);
        if (!ascendente) {
            comparadorPrecio = comparadorPrecio.reversed();
        }
        productoList = productoList.stream()
                .sorted(comparadorPrecio)
                .collect(Collectors.toCollection(ArrayList::new));
        return productoList;
    }

    public List<Product> getProductsBySearch(String busqueda) {
        List<Product> productoList = getProducts();
        int distancia = 4;
        return productoList.stream()
                .filter(producto -> {
                    String modelo = producto.getModelo();
                    String nombre = modelo;

                    return distanciaLevenshtein(busqueda, modelo) <= distancia ||
                            distanciaLevenshtein(busqueda, nombre) <= distancia;
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int distanciaLevenshtein(String a, String b) {
        int longitudA = a.length();
        int longitudB = b.length();
        int[][] distancia = new int[longitudA + 1][longitudB + 1];

        IntStream.rangeClosed(0, longitudA).forEach(i -> distancia[i][0] = i);
        IntStream.rangeClosed(0, longitudB).forEach(j -> distancia[0][j] = j);

        IntStream.range(1, longitudA + 1).forEach(i ->
                IntStream.range(1, longitudB + 1).forEach(j -> {
                    int costo = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                    distancia[i][j] = Math.min(Math.min(distancia[i - 1][j] + 1, distancia[i][j - 1] + 1), distancia[i - 1][j - 1] + costo);
                })
        );
        return distancia[longitudA][longitudB];
    }

    public List<Product> getProducts(){
        return  productRepository.findAll();
    }

    public List<String> getBranchs(){
        List<String> nombres_marcas = new ArrayList<>();
        for (Brand marca : branchRepository.findAll()){
            nombres_marcas.add(marca.getNombre());
        }
        return nombres_marcas;
    }

    //CRUD
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public List<Brand> getAllBrands(){
        return branchRepository.findAll();
    }

    public Product saveProducto(Product producto){
        productRepository.save(producto);
        return producto;
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product producto){
        saveProducto(producto);
        return producto;
    }

    public void deleteProducts() {
        productRepository.deleteAll();
    }
}
