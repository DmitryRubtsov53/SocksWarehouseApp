package dn.rubtsov.sockswarehouseapp.service;

import dn.rubtsov.sockswarehouseapp.exception.IncorrectDataExceptiom;
import dn.rubtsov.sockswarehouseapp.exception.NotEnoughQuantityException;
import dn.rubtsov.sockswarehouseapp.model.Color;
import dn.rubtsov.sockswarehouseapp.model.Size;
import dn.rubtsov.sockswarehouseapp.model.Socks;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class SocksServiceImpl implements SocksService {

private final HashMap<Socks, Integer> socksMap = new HashMap<>();

  @Override
  public void addSocks(SocksRequest socksRequest) {
    validateRequest(socksRequest);
    Socks socks = mapToSocks(socksRequest);
    if (socksMap.containsKey(socks)) {
        socksMap.put(socks, socksMap.get(socks) + socksRequest.getQuantity());
    } else socksMap.put(socks, socksRequest.getQuantity());
  }
    @Override
    public void releaseSocks(SocksRequest socksRequest) {
        validateRequest(socksRequest);
        Socks socks = mapToSocks(socksRequest);
        int socksQuantity = socksMap.getOrDefault(socks, 0);
        if (socksQuantity >= socksRequest.getQuantity()) {
            socksMap.put(socks, socksQuantity - socksRequest.getQuantity());
        } else throw new NotEnoughQuantityException("На складе недостаточно носков.");
    }
    @Override
    public int quantitySocks(Color color, Size size, Integer cottonMin, Integer cottonMax) {
      int total = 0;
      for (HashMap.Entry<Socks, Integer> entry : socksMap.entrySet()) {
          if (color != null && !entry.getKey().getColor().equals(color)) {
              continue;
          }
          if (size != null && !entry.getKey().getSize().equals(size)) {
              continue;
          }
          if (cottonMin != null && entry.getKey().getCotton() < cottonMin) {
              continue;
          }
          if (cottonMax != null && entry.getKey().getCotton() > cottonMax) {
              continue;
          }
          total += entry.getValue();
      }
      return total;
    }
    @Override
    public void removeSocks(SocksRequest socksRequest) {
        validateRequest(socksRequest);
        Socks socks = mapToSocks(socksRequest);
        int socksQuantity = socksMap.getOrDefault(socks, 0);
        if (socksQuantity >= socksRequest.getQuantity()) {
            socksMap.put(socks, socksQuantity - socksRequest.getQuantity());
        } else throw new NotEnoughQuantityException("На складе недостаточно носков.");
    }
//------------------------------------------------------------------------------------
  @Override
  public void validateRequest(SocksRequest socksRequest) {
      if (socksRequest.getColor() == null || socksRequest.getSize() == null) {
          throw new IncorrectDataExceptiom("Все поля должны быть заполнены.");
      }
      if (socksRequest.getCotton() < 0 || socksRequest.getCotton() > 100) {
          throw new IncorrectDataExceptiom("Содержание хлопка должно быть от 0 до 100%.");
      }
      if (socksRequest.getQuantity() <= 0) {
          throw new IncorrectDataExceptiom("Количество пар носков должно быть больше 0.");
      }
  }

  @Override
  public Socks mapToSocks(SocksRequest socksRequest) {
      return new Socks(socksRequest.getColor(),
              socksRequest.getSize(),
              socksRequest.getCotton());
  }
} // Class
