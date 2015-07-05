package com.tecsup.spring.jdbc;

import com.tecsup.spring.jdbc.dao.ProgramaDAO;
import com.tecsup.spring.jdbc.model.Programa;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext cntx = new ClassPathXmlApplicationContext("hibernate_db.xml");
        ProgramaDAO dao = (ProgramaDAO) cntx.getBean("programaDAO");

        App.eliminar(dao);
        App.listar(dao);
    }

    public static void eliminar(ProgramaDAO dao) {
        Programa programa = dao.get(855l);
        dao.delete(programa);
    }

    public static void actualizar(ProgramaDAO dao) {
        Programa programa = dao.get(851l);
        programa.setNombre("Programa Modificado");
        dao.update(programa);
    }

    public static void guardar(ProgramaDAO dao) {

        Programa programa = new Programa();
        programa.setNombre("Programa de José");
        programa.setDescripcion("Programa XYZ");
        programa.setCodigo("201");
        dao.save(programa);
    }

    public static void listar(ProgramaDAO dao) {
        List<Programa> programas = dao.list();

        for (Programa programa : programas) {
            System.out.println(programa.getId() + " " + programa.getNombre().toUpperCase());
        }

    }

}
