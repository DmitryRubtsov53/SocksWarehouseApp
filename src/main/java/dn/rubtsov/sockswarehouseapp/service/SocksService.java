package dn.rubtsov.sockswarehouseapp.service;

import dn.rubtsov.sockswarehouseapp.model.Color;
import dn.rubtsov.sockswarehouseapp.model.Size;
import dn.rubtsov.sockswarehouseapp.model.Socks;

public interface SocksService {
    void addSocks(SocksRequest socksRequest);

    void releaseSocks(SocksRequest socksRequest);

    int quantitySocks (Color color, Size size, Integer cottonMin, Integer cottonMax);

    void removeSocks(SocksRequest socksRequest);

    void validateRequest(SocksRequest socksRequest);

    Socks mapToSocks(SocksRequest socksRequest);
}
