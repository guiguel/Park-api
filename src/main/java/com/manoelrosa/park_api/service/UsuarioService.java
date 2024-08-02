package com.manoelrosa.park_api.service;

import com.manoelrosa.park_api.entity.Usuario;
import com.manoelrosa.park_api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRespository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRespository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id){
        return usuarioRespository.findById(id).orElseThrow(
                ()-> new RuntimeException("Usuário não encontrado!"));
    }

    @Transactional
    public Usuario updateSenha(Long id, String password) {
        Usuario user = buscarPorId(id);
        user.setPassword(password);
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRespository.findAll();
    }
}
