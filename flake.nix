{
  description = "A template for Nix based C++ project setup.";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";

    utils.url = "github:numtide/flake-utils";
    utils.inputs.nixpkgs.follows = "nixpkgs";
  };

  outputs = { self, nixpkgs, ... }@inputs: inputs.utils.lib.eachSystem [
    "x86_64-linux"
    "i686-linux"
    "aarch64-linux"
    "x86_64-darwin"
  ]
    (system:
      let
        pkgs = import nixpkgs {
          inherit system;
        };
      in
      {
        devShell = pkgs.mkShell rec {
          name = "libsbml";

          packages = with pkgs; [
            cmake
            cmakeCurses
            gdb
            libxml2.dev
          ];

          shellHook = ''
            export CMAKE_INCLUDE_PATH=${pkgs.libxml2.dev}/include/libxml2:$CMAKE_INCLUDE_PATH
          '';
        };
      });
}