"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
require("rxjs/add/operator/map");
var webServiceEndpoint = 'http://localhost:8080/api';
var UserService = (function () {
    function UserService(http) {
        this.http = http;
    }
    UserService.prototype.getAll = function () {
        return this.http.get(webServiceEndpoint + "/user").map(function (response) { return response.json(); });
    };
    UserService.prototype.getById = function (id) {
        return this.http.get((webServiceEndpoint + "/user/") + id).map(function (response) { return response.json(); });
    };
    UserService.prototype.create = function (user) {
        return this.http.post(webServiceEndpoint + "/user", user).map(function (response) { return response.json(); });
    };
    UserService.prototype.update = function (user) {
        return this.http.put(webServiceEndpoint + "/protected/user", user).map(function (response) { return response.json(); });
    };
    UserService.prototype.delete = function (id) {
        return this.http.delete((webServiceEndpoint + "/protected/user/") + id).map(function (response) { return response.json(); });
    };
    UserService.prototype.getCurrentUser = function () {
        return this.http.get(webServiceEndpoint + "/protected/user/me").map(function (response) { return response.json(); });
    };
    UserService = __decorate([
        core_1.Injectable()
    ], UserService);
    return UserService;
}());
exports.UserService = UserService;
