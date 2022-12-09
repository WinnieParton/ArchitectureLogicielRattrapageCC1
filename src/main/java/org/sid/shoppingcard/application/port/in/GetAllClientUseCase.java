package org.sid.shoppingcard.application.port.in;

import java.util.List;

import org.sid.kernel.QueryHandler;
import org.sid.shoppingcard.domain.Client;

public interface GetAllClientUseCase extends QueryHandler<ListClientQuery, List<Client>> {
}
