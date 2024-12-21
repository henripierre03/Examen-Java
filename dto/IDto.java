package gestion_commercial.dto;

public interface IDto<TDto, TModel> {

    TModel dtoToModel();  // Convertit le DTO en modèle

    TDto modelToDto(TModel model);  // Convertit le modèle en DTO
}
