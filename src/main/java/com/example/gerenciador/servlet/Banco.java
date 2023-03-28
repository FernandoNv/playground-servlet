package com.example.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {
    private static List<Empresa> lista = new ArrayList<>();
    private static Long chaveSequencial = 1L;

    static {
        Empresa empresa1 = new Empresa();
        empresa1.setId(chaveSequencial++);
        empresa1.setNome("Google");

        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Twitter");

        lista.addAll(Arrays.asList(empresa1, empresa2));
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(chaveSequencial++);
        Banco.lista.add(empresa);
    }

    public List<Empresa> getEmpresas(){
        return Collections.unmodifiableList(lista);
    }

    public void remove(Long idEmpresa) {
        Iterator<Empresa> iterator = lista.iterator();
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
        for (Empresa e : lista){
            if (e.getId().equals(idEmpresa)){
                empresa = e;
                break;
            }
        }

        return empresa;
    }
}
