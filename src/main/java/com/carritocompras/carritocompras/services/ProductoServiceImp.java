package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.dtos.ProductoDto;
import com.carritocompras.carritocompras.entities.Producto;
import com.carritocompras.carritocompras.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoServiceImp implements  IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findProductoById(long id) throws ClassNotFoundException {
        Optional<Producto> producto= productoRepository.findById(id);
        if(producto.isEmpty()){
            throw new ClassNotFoundException("Producto no encontrado bajo el id: "+id);
        }

        return producto.get();
    }

    @Override
    public Producto updateProducto(long id, ProductoDto producto) throws ClassNotFoundException {

        if(productoRepository.findById(id).isEmpty()){
            throw new ClassNotFoundException("Producto no encontrado bajo el id: "+id);
        }
        Producto productoToUpdate = productoRepository.findById(id).get();
        productoToUpdate.setDescripcion(producto.getDescripcion());
        productoToUpdate.setNombre(producto.getNombre());
        productoToUpdate.setValor(producto.getValor());
        productoToUpdate.setStock(producto.getStock());
        productoToUpdate.setImage(producto.getImage());
        return productoRepository.save(productoToUpdate);
    }

    @Override
    public void deleteProducto(long id) throws ClassNotFoundException {
        if(productoRepository.findById(id).isEmpty()){
            throw new ClassNotFoundException("Producto no encontrado bajo el id: "+id);
        }
        productoRepository.deleteById(id);

    }
}
