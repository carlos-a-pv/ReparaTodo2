package controlador;

import servicios.IModelFactoryService;

public class ModelFactoryController implements IModelFactoryService {



    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
}
