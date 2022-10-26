package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.CarritoCompra;
import com.carritocompras.carritocompras.exception.UserNotFoundException;
import com.carritocompras.carritocompras.repositories.CarritoCompraRepository;
import com.carritocompras.carritocompras.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarritoComprasServiceImp implements  ICarritoComprasService{

    private  final CarritoCompraRepository carritoCompraRepository;
    private  final UsuarioRepository usuarioRepository;
    @Override
    public CarritoCompra addProducto(CarritoCompra carritoCompra) {
        return carritoCompraRepository.save(carritoCompra);
    }

    @Override
    public List<CarritoCompra> getCarritoByUser(String userName) throws UserNotFoundException {
        if(usuarioRepository.findByUserName(userName).isEmpty()){
            throw new UserNotFoundException("El usuario "+userName+ " no existe");
        }
        return carritoCompraRepository.findByUsuario_UserName(userName);
    }

    @Override
    public void cleanCarriroCompras(String userName) throws UserNotFoundException {

        if(usuarioRepository.findByUserName(userName).isEmpty()){
            throw new UserNotFoundException("El usuario "+userName+ " no existe");
        }
        carritoCompraRepository.deleteByUsuario_UserName(userName);
    }

    @Override
    public void removeProducto(long id) throws ClassNotFoundException {
        if(carritoCompraRepository.findById(id).isEmpty()){
            throw  new ClassNotFoundException("No se encontro registro bajo el id: "+id);
        }
        carritoCompraRepository.deleteById(id);
    }
}
