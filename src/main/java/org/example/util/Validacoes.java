package org.example.util;

public class Validacoes {

    // Valida CPF (só verifica o formato, não a validade completa)
    public static boolean validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        return cpf.matches("\\d{11}");
    }

    // Valida se um email tem o formato correto (não é uma validação 100% segura, mas serve para formatos básicos)
    public static boolean validarEmail(String email) {
        if (email == null) return false;
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
}