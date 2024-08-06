package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return withTitleCont(params.getTitleCont())
                .and(withPriceAtLt(params.getPriceLt()))
                .and(withPriceAtGt(params.getPriceGt()))
                .and(withRaitingAtGt(params.getRatingGt()))
                .and(withCategoryId(params.getCategoryId()));
    }

    private Specification<Product> withTitleCont(String titleCont) {
        return (root, query, cb) -> titleCont == null ? cb.conjunction() : cb.like(cb.lower(root.get("title")), titleCont.toLowerCase());
    }

    private Specification<Product> withPriceAtLt(Integer priceLt) {
        return (root, query, cb) -> priceLt == null ? cb.conjunction() : cb.lessThan(root.get("price"), priceLt);
    }
    private Specification<Product> withPriceAtGt(Integer priceGt) {
        return (root, query, cb) -> priceGt == null ? cb.conjunction() : cb.greaterThan(root.get("price"), priceGt);
    }
    private Specification<Product> withRaitingAtGt(Double raitingGt) {
        return (root, query, cb) -> raitingGt == null ? cb.conjunction() : cb.greaterThan(root.get("rating"), raitingGt);
    }
    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, cb) -> categoryId == null ? cb.conjunction() : cb.equal(root.get("category").get("id"), categoryId);
    }

}
// END
