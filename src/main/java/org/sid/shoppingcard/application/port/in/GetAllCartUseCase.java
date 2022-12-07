package org.sid.shoppingcard.application.port.in;

import java.util.List;

import org.sid.kernel.QueryHandler;
import org.sid.shoppingcard.domain.Cart;

public interface GetAllCartUseCase extends QueryHandler<ListCartQuery, List<Cart>> {
}
