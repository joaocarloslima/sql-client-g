package br.com.fiap;

import java.util.ArrayList;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class CallbackImp implements Callback {

    private int index;

    public CallbackImp(int index){
        this.index = index;
    }    
    
    @Override
    public Object call(Object param) {
        TableColumn.CellDataFeatures<ArrayList<String>, String> p = (CellDataFeatures<ArrayList<String>, String>) param;
        return new ReadOnlyStringWrapper(p.getValue().get(index).toString());
    }
   
}
