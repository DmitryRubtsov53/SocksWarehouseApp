package dn.rubtsov.sockswarehouseapp.controllers;

import dn.rubtsov.sockswarehouseapp.service.SocksRequest;
import dn.rubtsov.sockswarehouseapp.model.Color;
import dn.rubtsov.sockswarehouseapp.model.Size;
import dn.rubtsov.sockswarehouseapp.service.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/socks")
@Tag(name = "СКЛАД НОСКОВ", description = "Количественный учет операций с носками на складе.")
public class SocksController {

    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping("/")
    @Operation( summary = "Регистрация прихода товара на склад."    )
    @ApiResponses ( {
            @ApiResponse ( responseCode = "200",
                    description = "Удалось добавить приход.",
                    content = {  @Content (mediaType = "application/json") } ),
            @ApiResponse( responseCode = "400",
                    description = "Параметры запроса отсутствуют или имеют некорректный формат."  ),
            @ApiResponse( responseCode = "500",
                    description = "Произошла ошибка, не зависящая от вызывающей стороны."  )
    } )
    public void addSocks(@RequestBody SocksRequest socksRequest) {
        socksService.addSocks(socksRequest);
    }
//----------------------------------------------------------------------------------------------------
    @PutMapping("/")
    @Operation( summary = "Регистрация отпуска носков со склада."    )
    @ApiResponses ( {
            @ApiResponse ( responseCode = "200",
                    description = "Удалось произвести отпуск носков со склада.",
                    content = {  @Content (mediaType = "application/json") } ),
            @ApiResponse( responseCode = "400",
                    description = "Товара нет на складе в нужном количестве или параметры запроса имеют " +
                            "некорректный формат."  ),
            @ApiResponse( responseCode = "500",
                    description = "Произошла ошибка, не зависящая от вызывающей стороны."  )
    } )
    public void releaseSocks(@RequestBody SocksRequest socksRequest) {
        socksService.releaseSocks(socksRequest);
    }
//----------------------------------------------------------------------------------------------------
    @GetMapping("/")
    @Operation( summary = "Возвращает общее количество носков на складе, соответствующих параметрам запроса."    )
    @ApiResponses ( {
            @ApiResponse ( responseCode = "200",
                    description = "запрос выполнен, результат в теле ответа в виде целого числа.",
                    content = {  @Content (mediaType = "application/json") } ),
            @ApiResponse( responseCode = "400",
                    description = "Параметры запроса отсутствуют или имеют некорректный формат."  ),
            @ApiResponse( responseCode = "500",
                    description = "Произошла ошибка, не зависящая от вызывающей стороны."  )
    } )
    public int quantitySocks(@RequestParam (required = false, name = "Цвет") Color color,
                             @RequestParam (required = false, name = "Размер") Size size,
                             @RequestParam (required = false, name = "Мin % хлопка") Integer cottonMin,
                             @RequestParam (required = false, name = "Мах % хлопка") Integer cottonMax) {
        return socksService.quantitySocks(color, size, cottonMin, cottonMax);
    }
//----------------------------------------------------------------------------------------------------
    @DeleteMapping("/")
    @Operation( summary = "Списание брака носков со склада."    )
    @ApiResponses ( {
            @ApiResponse ( responseCode = "200",
                    description = "Запрос выполнен, товар списан со склада.",
                    content = {  @Content (mediaType = "application/json") } ),
            @ApiResponse( responseCode = "400",
                    description = "Параметры запроса отсутствуют или имеют некорректный формат."  ),
            @ApiResponse( responseCode = "500",
                    description = "Произошла ошибка, не зависящая от вызывающей стороны."  )
    } )
    public void removeSocks(@RequestBody SocksRequest socksRequest) {
        socksService.removeSocks(socksRequest);
    }

}
