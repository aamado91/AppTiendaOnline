package com.ucompensar.apptiendaonline.ui.compras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComprasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ComprasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Carrito de compras");
    }

    public LiveData<String> getText() {
        return mText;
    }
}