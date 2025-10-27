package org.example.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<T> {
        void inserir(T t) throws SQLException;
        List<T> listar() throws SQLException;
        void atualizar(T t) throws SQLException;
        void excluir(int id) throws SQLException;
    }

