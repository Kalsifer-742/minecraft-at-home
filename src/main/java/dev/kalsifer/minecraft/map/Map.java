package dev.kalsifer.minecraft.map;

import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.blocks.*;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.BlockPane;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Map extends GridPane {
    private final Block[][] blocks;
    private final int size;

    public Map(int size) {
        super();

        this.size = size;
        blocks = new Block[this.size][this.size];

        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                blocks[x][y] = BlockFactory.airBlock();
            }
        }

        Random rand = new Random();
        for (int i = 0 ; i < 5; i++){
            int x = rand.nextInt(this.size);
            int y = rand.nextInt(this.size);
            try {
                this.insertBlockAtCoords(new Coordinate(x, y), BlockFactory.sandBlock());
            } catch (CoordinateOutOfBoundException ignored) {}
        }
        this.addRowOfWater();

        this.draw();
    }

    public void draw() {
        for (int y = this.size - 1; y > -1 ; y--) {
            for (int x = 0; x < this.size; x++) {
                super.add(new BlockPane(this.blocks[x][y]), x, this.size - y);
            }
        }
    }

    private boolean isCoordinateValid(Coordinate coord) {
        return coord.x >= 0
                && coord.x < this.size
                && coord.y >= 0
                && coord.y < this.size;
    }

    private void swap(Coordinate coord) {
        Block tmp = this.blocks[coord.x][coord.y];
        this.blocks[coord.x][coord.y] = this.blocks[coord.x][coord.y - 1];
        this.blocks[coord.x][coord.y - 1] = tmp;
    }

    public Block removeBlockAtCoord(Coordinate coord) throws CoordinateOutOfBoundException, BlockIsNotPickableException {
        if (!this.isCoordinateValid(coord)) {
            throw new CoordinateOutOfBoundException();
        } else if (!this.blocks[coord.x][coord.y].isPickable()) {
            throw new BlockIsNotPickableException();
        }

        Block block = this.blocks[coord.x][coord.y];
        this.blocks[coord.x][coord.y] = BlockFactory.airBlock();

        if (coord.y == this.size - 1 || (!this.blocks[coord.x][coord.y + 1].doFallsWithGravity() && !this.blocks[coord.x][coord.y + 1].doBlocksFallThrough())) {
            return block;
        }

        int z = coord.y;
        while (z != this.size - 1 && (this.blocks[coord.x][z + 1].doFallsWithGravity() || this.blocks[coord.x][z + 1].doBlocksFallThrough())) {
            if (this.blocks[coord.x][z + 1].doFallsWithGravity()) {
                this.swap(new Coordinate(coord.x, z + 1));
            }
            z++;
        }

        return block;
    }

    public void insertBlockAtCoords(Coordinate coord, Block block) throws CoordinateOutOfBoundException {
        if (!this.isCoordinateValid(coord)) {
            throw new CoordinateOutOfBoundException();
        }

        this.blocks[coord.x][coord.y] = block;

        if (!this.blocks[coord.x][coord.y].doFallsWithGravity()) {
            return;
        }

        int z = coord.y;
        while (z != 0 && this.blocks[coord.x][z - 1].doBlocksFallThrough()) {
            this.swap(new Coordinate(coord.x, z));
            z--;
        }
    }

    public void addRowOfWater() {
        for (int x = 0; x < this.size; x++) {
            try {
                this.insertBlockAtCoords(new Coordinate(x, this.size - 1), BlockFactory.waterBlock());
            } catch (CoordinateOutOfBoundException ignored) {}
        }
    }
}
