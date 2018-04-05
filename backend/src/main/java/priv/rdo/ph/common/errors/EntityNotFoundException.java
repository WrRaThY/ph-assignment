package priv.rdo.ph.common.errors;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class entityClass, String id) {
        super(entityClass.getSimpleName() + " was not found for given id: " + id);
    }
}
