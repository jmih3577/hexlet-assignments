package exercise.mapper;

// BEGIN

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.*;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductMapper {

    @Mapping(target = "barcode", source = "vendorCode")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "name", source = "title")
    public abstract Product map(ProductCreateDTO prodCreate);

    @Mapping(target = "vendorCode", source = "barcode")
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "title", source = "name")
    public abstract ProductDTO map(Product prod);

    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO prodUpdate, @MappingTarget Product prod);
}
// END
