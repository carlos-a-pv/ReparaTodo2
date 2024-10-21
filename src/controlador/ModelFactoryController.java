package controlador;

import servicios.IModelFactoryService;

public class ModelFactoryController implements IModelFactoryService {

    @Override
    public boolean iniciarSesion(String email, String password) {
        return false;
    }

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
}
