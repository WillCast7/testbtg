package com.btgpactual.ssf.util;

public class constants {
    public static class messages {
        public static final String error = "Ha ocurrido un error: ";
        public static final String noData = "No encontró ningún dato";
        public static final String consultGood = "Consultado correctamente";
        public static final String responseSaveUserGood = "Datos creado correctamente";
        public static final String responseUpdateGood = "Datos actualizados correctamente";
        public static final String getResponseSaveError = "Error al crear: ";
        public static final String getResponseEditError = "Error al editar: ";
        public static final String getGetResponseErrorSwitchDTOToEntity = "Error al convertir DTO a Entity: el objeto es nulo.";
        public static final String getResponseUpdateError = "Error al intentar Actializad datos";
        public static final String errorLowAmmount = "No tiene saldo disponible para vincularse al fondo ";
        public static final String errorlowTransaction = "El monto minimo para esta transaccion es de ";
        public static final String errorUnsubscriptionForSubscription = "El usuario no tiene aperturas hechas";
    }
    public static class variables{
        public static final String subscription = "apertura";
        public static final String unsubscription = "cancelacion";
    }
}
