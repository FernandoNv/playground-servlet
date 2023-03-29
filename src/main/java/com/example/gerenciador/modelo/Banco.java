package com.example.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Banco {
    private static List<Empresa> listaEmpresas = new ArrayList<>();
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    private static Long chaveSequencial = 1L;

    static {
        Empresa empresa1 = new Empresa();
        empresa1.setId(chaveSequencial++);
        empresa1.setNome("Google");

        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Twitter");

        Usuario usuario1 = new Usuario();
        usuario1.setLogin("fernando");
        usuario1.setSenha("123456");

        Usuario usuario2 = new Usuario();
        usuario2.setLogin("carina");
        usuario2.setSenha("123");

        listaEmpresas.addAll(Arrays.asList(empresa1, empresa2));
        listaUsuarios.addAll(Arrays.asList(usuario1, usuario2));
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(chaveSequencial++);
        Banco.listaEmpresas.add(empresa);
    }

    public List<Empresa> getEmpresas(){
        return Collections.unmodifiableList(listaEmpresas);
    }

    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(listaUsuarios);
    }

    public void remove(Long idEmpresa) {
        Iterator<Empresa> iterator = listaEmpresas.iterator();
        while(iterator.hasNext()){
            Empresa empresa = iterator.next();
            if(empresa.getId().equals(idEmpresa)){
                iterator.remove();
                break;
            }
        }
    }

    public Empresa getEmpresaById(Long idEmpresa) {
        Empresa empresa = null;
        for (Empresa e : listaEmpresas){
            if (e.getId().equals(idEmpresa)){
                empresa = e;
                break;
            }
        }

        return empresa;
    }

    public Usuario existeUsuario(String login, String senha) {
        for (Usuario usuario : listaUsuarios){
            if(usuario.ehIgual(login, senha)) return usuario;
        }

        return null;
    }
}
