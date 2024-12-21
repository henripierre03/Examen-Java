package gestion_commercial.fabrique;

import gestion_commercial.dao.*;
import gestion_commercial.services.IService;
import gestion_commercial.services.Service;

public class Fabrique {

    public static IService getInstanceService() {
        return new Service(
            new DaoClient(),
            new DaoUser(),
            new DaoProduit(),
            new DaoCommande(),
            new DaoRole(),
            new DaoSousCategorie(),
            new DaoDetail()
        );
    }
}
