package com.echo.echoband;

import com.fazecast.jSerialComm.SerialPort;

public class SerialReader {
    private SerialPort port;
    private boolean receivingData = false;

    // Método para comenzar a recibir datos
    public void comenzarARecibirDatos() {
        // Obtiene todos los puertos seriales disponibles
        SerialPort[] ports = SerialPort.getCommPorts();

        // Muestra los puertos disponibles en la consola
        System.out.println("Puertos disponibles:");
        for (SerialPort p : ports) {
            System.out.println(p.getSystemPortName());
        }

        // Selecciona el puerto serial correcto
        port = SerialPort.getCommPort("COM8"); // Cambia a tu puerto correcto

        // Configura el puerto: 9600 baudios, 8 bits de datos, 1 bit de parada, sin paridad
        port.setBaudRate(9600);
        port.setNumDataBits(8);
        port.setNumStopBits(1);
        port.setParity(SerialPort.NO_PARITY);

        // Abre el puerto para lectura
        if (port.openPort()) {
            System.out.println("Puerto abierto exitosamente");
            receivingData = true;
            leerDatos();
        } else {
            System.out.println("No se pudo abrir el puerto");
        }
    }

    // Método para leer los datos en un hilo separado
    private void leerDatos() {
        new Thread(() -> {
            byte[] readBuffer = new byte[1024];
            while (receivingData) {
                int numRead = port.readBytes(readBuffer, readBuffer.length);
                if (numRead > 0) {
                    String data = new String(readBuffer, 0, numRead);
                    System.out.println("Datos recibidos: " + data);
                }
                // Espera 1 segundo antes de leer nuevamente
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        receivingData = false;
        if (port != null && port.isOpen()) {
            port.closePort();
            System.out.println("Puerto cerrado exitosamente");
        }
    }
}
