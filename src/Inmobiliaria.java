import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Inmobiliaria {
    ArrayList<Cliente> clientes;
    private final ArrayList<Propiedad> propiedades;

    public Inmobiliaria() {
        this.clientes = new ArrayList<>();
        this.propiedades = new ArrayList<>();


        clientes.add(new Cliente("Carlos Pérez", "3101234567", "Calle 123 #45-67", "Ingeniero", "ABC Ltda.", "Apartamento moderno", 5000000));
        clientes.add(new Cliente("María Rodríguez", "3117654321", "Carrera 10 #20-30", "Doctora", "Hospital XYZ", "Casa amplia", 7000000));
        clientes.add(new Cliente("Juan Gómez", "3201122334", "Avenida 68 #90-12", "Abogado", "Firma Legal SAS", "Apartamento lujoso", 8000000));
        clientes.add(new Cliente("Laura Martínez", "3153344556", "Calle 80 #25-45", "Arquitecta", "Design Studio", "Casa con jardín", 6000000));
        clientes.add(new Cliente("Pedro Sánchez", "3199988776", "Carrera 7 #45-56", "Contador", "Finanzas y Cia", "Apartamento céntrico", 5500000));
        clientes.add(new Cliente("Ana Ruiz", "3177766554", "Calle 100 #20-40", "Diseñadora", "Creativa SAS", "Casa espaciosa", 7500000));
        clientes.add(new Cliente("Luis Torres", "3123456789", "Avenida Suba #34-45", "Profesor", "Colegio ABC", "Apartamento cerca del parque", 4000000));
        clientes.add(new Cliente("Sofía Díaz", "3166543322", "Calle 50 #10-20", "Chef", "Restaurante Gourmet", "Casa moderna", 9000000));
        clientes.add(new Cliente("Miguel Ángel", "3182233445", "Carrera 15 #60-70", "Médico", "Clínica Med", "Apartamento nuevo", 9500000));
        clientes.add(new Cliente("Juliana López", "3145566778", "Calle 45 #35-36", "Ingeniera de Sistemas", "Tech Solutions", "Casa de tres niveles", 8500000));


        propiedades.add(new Propiedad("SNR001", "Calle 100 #15-30", "3109876543", "Chapinero", "Norte", 2500000, "Apartamento de 2 habitaciones"));
        propiedades.add(new Propiedad("SNR002", "Carrera 7 #50-25", "3123456789", "Teusaquillo", "Centro", 3000000, "Casa de 3 habitaciones"));
        propiedades.add(new Propiedad("SNR003", "Calle 85 #20-10", "3134567890", "Usaquén", "Norte", 4500000, "Apartamento de lujo con 3 habitaciones"));
        propiedades.add(new Propiedad("SNR004", "Avenida 68 #90-12", "3112233445", "Barrios Unidos", "Occidente", 2000000, "Apartamento de 1 habitación"));
        propiedades.add(new Propiedad("SNR005", "Calle 80 #25-45", "3103344556", "Engativá", "Occidente", 3500000, "Casa con jardín y 4 habitaciones"));
        propiedades.add(new Propiedad("SNR006", "Carrera 7 #45-56", "3199988776", "Chapinero", "Norte", 5500000, "Apartamento céntrico de 3 habitaciones"));
        propiedades.add(new Propiedad("SNR007", "Calle 100 #20-40", "3177766554", "Usaquén", "Norte", 4000000, "Casa espaciosa con 5 habitaciones"));
        propiedades.add(new Propiedad("SNR008", "Avenida Suba #34-45", "3123456789", "Suba", "Norte", 6000000, "Apartamento cerca del parque con 2 habitaciones"));
        propiedades.add(new Propiedad("SNR009", "Calle 50 #10-20", "3166543322", "Teusaquillo", "Centro", 7000000, "Casa moderna con 3 niveles"));
        propiedades.add(new Propiedad("SNR010", "Carrera 15 #60-70", "3182233445", "Chapinero", "Norte", 8000000, "Apartamento nuevo de 3 habitaciones"));
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarPropiedad(Propiedad propiedad) {
        propiedades.add(propiedad);
    }

    public ArrayList<Propiedad> getPropiedadesDisponibles() {
        ArrayList<Propiedad> disponibles = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (!p.isAlquilada()) {
                disponibles.add(p);
            }
        }
        return disponibles;
    }

    public ArrayList<Propiedad> buscarPropiedadesPorPrecio(int precio) {
        ArrayList<Propiedad> resultado = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecioAlquiler() == precio) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public ArrayList<Propiedad> buscarPropiedadesPorZonaYPrecio(String zona, int precio) {
        ArrayList<Propiedad> resultado = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getZona().equalsIgnoreCase(zona) && p.getPrecioAlquiler() == precio) {
                resultado.add(p);
            }
        }
        return resultado;
    }


    public void alquilarPropiedad(String snr, Cliente cliente) {
        for (Propiedad p : propiedades) {
            if (p.getSnr().equals(snr) && !p.isAlquilada()) {
                p.setAlquilada(true);
                p.setInquilino(cliente);
                break;
            }
        }
    }


}

class Cliente {
    private String nombre;
    private String telefono;
    private String direccion;
    private String profesion;
    private String lugarTrabajo;
    private String descripcionPropiedad;
    private int salario;


    public Cliente(String nombre, String telefono, String direccion, String profesion, String lugarTrabajo, String descripcionPropiedad, int salario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.profesion = profesion;
        this.lugarTrabajo = lugarTrabajo;
        this.descripcionPropiedad = descripcionPropiedad;
        this.salario = salario;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getProfesion() { return profesion; }
    public void setProfesion(String profesion) { this.profesion = profesion; }
    public String getLugarTrabajo() { return lugarTrabajo; }
    public void setLugarTrabajo(String lugarTrabajo) { this.lugarTrabajo = lugarTrabajo; }
    public String getDescripcionPropiedad() { return descripcionPropiedad; }
    public void setDescripcionPropiedad(String descripcionPropiedad) { this.descripcionPropiedad = descripcionPropiedad; }
    public int getSalario() { return salario; }
    public void setSalario(int salario) { this.salario = salario; }
}

class Propiedad {
    private String snr;
    private String direccion;
    private String telefono;
    private String barrio;
    private String zona;
    private int precioAlquiler;
    private String descripcionPropiedad;
    private boolean alquilada;
    private Cliente inquilino;


    public Propiedad(String snr, String direccion, String telefono, String barrio, String zona, int precioAlquiler, String descripcionPropiedad) {
        this.snr = snr;
        this.direccion = direccion;
        this.telefono = telefono;
        this.barrio = barrio;
        this.zona = zona;
        this.precioAlquiler = precioAlquiler;
        this.descripcionPropiedad = descripcionPropiedad;
        this.alquilada = false;
        this.inquilino = null;
    }

    // Getters y Setters
    public String getSnr() { return snr; }
    public void setSnr(String snr) { this.snr = snr; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getBarrio() { return barrio; }
    public void setBarrio(String barrio) { this.barrio = barrio; }
    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }
    public int getPrecioAlquiler() { return precioAlquiler; }
    public void setPrecioAlquiler(int precioAlquiler) { this.precioAlquiler = precioAlquiler; }
    public String getDescripcionPropiedad() { return descripcionPropiedad; }
    public void setDescripcionPropiedad(String descripcionPropiedad) { this.descripcionPropiedad = descripcionPropiedad; }
    public boolean isAlquilada() { return alquilada; }
    public void setAlquilada(boolean alquilada) { this.alquilada = alquilada; }
    public Cliente getInquilino() { return inquilino; }
    public void setInquilino(Cliente inquilino) { this.inquilino = inquilino; }
}

class ClienteForm extends JFrame {
    private JTextField nombreField;
    private JTextField telefonoField;
    private JTextField direccionField;
    private JTextField profesionField;
    private JTextField lugarTrabajoField;
    private JTextField descripcionPropiedadField;
    private JTextField salarioField;
    private Inmobiliaria inmobiliaria;

    public ClienteForm(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
        setTitle("Datos del Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLUE);
        JLabel titleLabel = new JLabel("DATOS DEL CLIENTE");
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        panel.add(titlePanel);

        JPanel formPanel = new JPanel(new GridLayout(7, 2));

        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        formPanel.add(telefonoField);

        formPanel.add(new JLabel("Dirección:"));
        direccionField = new JTextField();
        formPanel.add(direccionField);

        formPanel.add(new JLabel("Profesión:"));
        profesionField = new JTextField();
        formPanel.add(profesionField);

        formPanel.add(new JLabel("Lugar de Trabajo:"));
        lugarTrabajoField = new JTextField();
        formPanel.add(lugarTrabajoField);

        formPanel.add(new JLabel("Descripción de la Propiedad:"));
        descripcionPropiedadField = new JTextField();
        formPanel.add(descripcionPropiedadField);

        formPanel.add(new JLabel("Salario:"));
        salarioField = new JTextField();
        formPanel.add(salarioField);

        panel.add(formPanel);

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));

        JButton submitButton = new JButton("Guardar");
        submitButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String telefono = telefonoField.getText();
            String direccion = direccionField.getText();
            String profesion = profesionField.getText();
            String lugarTrabajo = lugarTrabajoField.getText();
            String descripcionPropiedad = descripcionPropiedadField.getText();
            int salario = Integer.parseInt(salarioField.getText());

            Cliente cliente = new Cliente(nombre, telefono, direccion, profesion, lugarTrabajo, descripcionPropiedad, salario);
            inmobiliaria.agregarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cliente guardado con éxito");
        });
        buttonPanel.add(submitButton);

        JButton showAvailablePropertiesButton = new JButton("Mostrar Propiedades Disponibles");
        showAvailablePropertiesButton.addActionListener(e -> {
            ArrayList<Propiedad> disponibles = inmobiliaria.getPropiedadesDisponibles();
            StringBuilder message = new StringBuilder("Propiedades disponibles:\n");
            for (Propiedad p : disponibles) {
                message.append(p.getDireccion()).append("\n");
            }
            JOptionPane.showMessageDialog(this, message.toString());
        });
        buttonPanel.add(showAvailablePropertiesButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        SwingUtilities.invokeLater(() -> {
            new ClienteForm(inmobiliaria).setVisible(true);
        });
    }
}

class PropiedadForm extends JFrame {
    private JTextField snrField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JTextField barrioField;
    private JTextField zonaField;
    private JTextField precioAlquilerField;
    private JTextField descripcionPropiedadField;
    private final Inmobiliaria inmobiliaria;

    public PropiedadForm(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
        setTitle("Datos de la Propiedad");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLUE);
        JLabel titleLabel = new JLabel("DATOS DE LA PROPIEDAD");
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        panel.add(titlePanel);

        JPanel formPanel = new JPanel(new GridLayout(7, 2));

        formPanel.add(new JLabel("SNR (Número de Matrícula):"));
        snrField = new JTextField();
        formPanel.add(snrField);

        formPanel.add(new JLabel("Dirección:"));
        direccionField = new JTextField();
        formPanel.add(direccionField);

        formPanel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        formPanel.add(telefonoField);

        formPanel.add(new JLabel("Barrio:"));
        barrioField = new JTextField();
        formPanel.add(barrioField);

        formPanel.add(new JLabel("Zona:"));
        zonaField = new JTextField();
        formPanel.add(zonaField);

        formPanel.add(new JLabel("Precio Alquiler:"));
        precioAlquilerField = new JTextField();
        formPanel.add(precioAlquilerField);

        formPanel.add(new JLabel("Descripción de la Propiedad:"));
        descripcionPropiedadField = new JTextField();
        formPanel.add(descripcionPropiedadField);

        panel.add(formPanel);

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        JButton submitButton = new JButton("Guardar");
        submitButton.addActionListener(e -> {
            try {

                String snr = snrField.getText();
                String direccion = direccionField.getText();
                String telefono = telefonoField.getText();
                String barrio = barrioField.getText();
                String zona = zonaField.getText();
                int precioAlquiler = Integer.parseInt(precioAlquilerField.getText());
                String descripcionPropiedad = descripcionPropiedadField.getText();

                Propiedad propiedad = new Propiedad(snr, direccion, telefono, barrio, zona, precioAlquiler, descripcionPropiedad);
                inmobiliaria.agregarPropiedad(propiedad);
                JOptionPane.showMessageDialog(this, "Propiedad guardada con éxito");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce un precio de alquiler válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(submitButton);

        JButton rentPropertyButton = new JButton("Registrar Propiedad Alquilada");
        rentPropertyButton.addActionListener(e -> {
            String snr = snrField.getText();
            String nombreCliente = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:");
            Cliente cliente = null;
            for (Cliente c : inmobiliaria.clientes) {
                if (c.getNombre().equalsIgnoreCase(nombreCliente)) {
                    cliente = c;
                    break;
                }
            }
            if (cliente != null) {
                inmobiliaria.alquilarPropiedad(snr, cliente);
                JOptionPane.showMessageDialog(this, "Propiedad alquilada con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(rentPropertyButton);

        JButton searchPropertiesButton = new JButton("Buscar Propiedades por Precio");
        searchPropertiesButton.addActionListener(e -> {
            try {
                int precio = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el precio de alquiler:"));
                ArrayList<Propiedad> resultado = inmobiliaria.buscarPropiedadesPorPrecio(precio);
                StringBuilder message = new StringBuilder("Propiedades encontradas:\n");
                for (Propiedad p : resultado) {
                    message.append(p.getDireccion()).append("\n");
                }
                JOptionPane.showMessageDialog(this, message.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce un precio válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(searchPropertiesButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        SwingUtilities.invokeLater(() -> {
            new PropiedadForm(inmobiliaria).setVisible(true);
        });
    }
}