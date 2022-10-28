/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller.pablo.nunez.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author martosfre
 */
@FacesValidator("valCant")
public class ValidadorCantidad implements Validator<Integer>{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Integer valor) throws ValidatorException {
        
        if(valor <= 0 ){
            FacesMessage mensajeErr = new FacesMessage("La cantidad no puede ser negativa");
            mensajeErr.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(mensajeErr);
        }
    }

    
    
}
