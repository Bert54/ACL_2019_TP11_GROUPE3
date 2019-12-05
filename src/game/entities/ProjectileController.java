package game.entities;

import game.level.Vec2;

public class ProjectileController implements EntityController {
    public ProjectileController(Projectile projectile) {
        this.projectile = projectile;
    }

    public void onUpdate() {
        projectile.moveProjectile();
    }

    private Projectile projectile;
}
