package br.com.wm.springbootmongodb.controllers;

import br.com.wm.springbootmongodb.entities.Person;
import br.com.wm.springbootmongodb.entities.Product;
import br.com.wm.springbootmongodb.repositories.ProductRepository;
import io.swagger.annotations.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value="Sistema de Gestão de Vendas", description = "Operações referentes a produtos")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value = "Retorna uma lista de produtos disponíveis", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista recuperada com sucesso"),
            @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
            @ApiResponse(code = 403, message = "O recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Retorna um produto a partir do id", response = Product.class)
    public Product getProduct(@ApiParam(value = "Id do produto para recuperação do objeto", required = true) @PathVariable("id") ObjectId id) {
        return productRepository.findBy_id(id);
    }

    @PostMapping("/products")
    @ApiOperation(value = "Cria um produto", response = Product.class)
    public Product createProduct(@ApiParam(value = "Objeto do produto para persistência", required = true) @Valid @RequestBody Product product) {
        product.set_id(ObjectId.get());
        productRepository.save(product);
        return product;
    }

    @PutMapping("/products/{id}")
    @ApiOperation(value = "Atualiza um produto")
    public void updateProduct(@ApiParam(value = "Id do produto para atualização do objeto", required = true) @PathVariable("id") ObjectId id,
                              @ApiParam(value = "Objeto do produto para atualização", required = true) @Valid @RequestBody Product product) {
        product.set_id(id);
        productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    @ApiOperation(value = "Exclui um produto a partir do id")
    public void deleteProduct(@ApiParam(value = "Id do produto para exclusão do objeto", required = true) @PathVariable ObjectId id) {
        productRepository.delete(productRepository.findBy_id(id));
    }

}
