package beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

    

    @XmlRootElement(name="CURPStruct")
public class CURPStruct implements Serializable {
    private static long serialVersionUID = -3358884679090829992L;
        //ELEMENTOS
    String CURP;
    String CURPORIGINAL;
    String apellido1;
    String apellido2;
    String nombres;
    String sexo;
    String fechNac; 
    String nacionalidad;
    String cveEntidadNac;
    String statusCurp;
    boolean ACTUALIZO;

    //ATRIBUTOS
    String statusOper;

        @XmlElement
    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    @XmlElement
    public String getCURPORIGINAL() {
        return CURPORIGINAL;
    }

    public void setCURPORIGINAL(String CURPORIGINAL) {
        this.CURPORIGINAL = CURPORIGINAL;
    }
    
    
    
    
        @XmlElement
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    @XmlElement
    public String getFechNac() {
return fechNac;
}

public void setFechNac(String fechNac) {
this.fechNac = fechNac;
}

@XmlElement

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @XmlElement
    public String getCveEntidadNac() {
        return cveEntidadNac;
    }

    public void setCveEntidadNac(String cveEntidadNac) {
        this.cveEntidadNac = cveEntidadNac;
    }

    @XmlElement
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    @XmlElement
    public boolean getACTUALIZO() {
        return ACTUALIZO;
    }

    public void setACTUALIZO(boolean ACTUALIZO) {
        this.ACTUALIZO = ACTUALIZO;
    }

    @XmlElement
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @XmlElement
    public String getSexo() {
return sexo;
}

public void setSexo(String sexo) {
this.sexo = sexo;
}
   
    
    @XmlElement

    public String getStatusCurp() {
        return statusCurp;
    }

  

public void setStatusCurp(String statusCurp) {
        this.statusCurp = statusCurp;
    }


    @XmlAttribute

    public String getStatusOper() {
        return statusOper;
    }

    public void setStatusOper(String statusOper) {
        this.statusOper = statusOper;
    }


}
