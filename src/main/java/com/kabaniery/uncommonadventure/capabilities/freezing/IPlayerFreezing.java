package com.kabaniery.uncommonadventure.capabilities.freezing;

public interface IPlayerFreezing {
    boolean isDisabled();

    void setDisabled(boolean disabled);

    double getFreezing();

    void substractFreezing(int resistance);

    void addFreezing(double amount);

    void copyFrom(PlayerFreezing other);
}
