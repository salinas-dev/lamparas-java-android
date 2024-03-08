package com.salinas.norasalinasexamen.model;

public class Lampara {
    private String tipo;
    private int cantidad;
    private double precioProduccion;
    private double precioVenta;

    private final double PRECIO_NORMAL = 50.0;
    private final double PRECIO_BURO = PRECIO_NORMAL * 1.5;
    private final double PRECIO_DECORATIVA = PRECIO_BURO * 3.0;
    private final double PORCENTAJE_AUMENTO = 0.85;

    private final double DESCUENTO_1 = 0.15;
    private final double DESCUENTO_2 = 0.20;
    private final double DESCUENTO_3 = 0.25;
    private final double MONTO_DESCUENTO_1 = 1000.0;
    private final double MONTO_DESCUENTO_2 = 3000.0;
    private final double MONTO_DESCUENTO_3 = 5000.0;

    public Lampara(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        calcularPrecioProduccion();
        calcularPrecioVenta();
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    private void calcularPrecioProduccion() {
        switch (tipo.toLowerCase()) {
            case "normal":
                precioProduccion = PRECIO_NORMAL;
                break;
            case "buro":
                precioProduccion = PRECIO_BURO;
                break;
            case "decorativa":
                precioProduccion = PRECIO_DECORATIVA;
                break;
            default:
                throw new IllegalArgumentException("Tipo de lámpara inválido: " + tipo);
        }
    }

    private void calcularPrecioVenta() {
        precioVenta = precioProduccion * PORCENTAJE_AUMENTO * cantidad;
    }

    public double calcularDescuento(double precioVenta) {
        double descuento = 0.0;
        if (precioVenta > MONTO_DESCUENTO_3) {
            descuento = precioVenta * DESCUENTO_3;
        } else if (precioVenta > MONTO_DESCUENTO_2) {
            descuento = precioVenta * DESCUENTO_2;
        } else if (precioVenta > MONTO_DESCUENTO_1) {
            descuento = precioVenta * DESCUENTO_1;
        }
        return descuento;
    }

    public double calcularTotalCompra() {
        double totalCompra = precioVenta;
        if (totalCompra > MONTO_DESCUENTO_3) {
            totalCompra -= totalCompra * DESCUENTO_3;
        } else if (totalCompra > MONTO_DESCUENTO_2) {
            totalCompra -= totalCompra * DESCUENTO_2;
        } else if (totalCompra > MONTO_DESCUENTO_1) {
            totalCompra -= totalCompra * DESCUENTO_1;
        }
        return totalCompra;
    }
}