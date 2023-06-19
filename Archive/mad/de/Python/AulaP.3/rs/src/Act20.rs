// Sin terminar
use std::io;

const PI = 3.14159265359;

fn get_next_float() -> f32{
    mut let str_in = io::stdin().read_line();
    str_in.parse::<f32>().unwrap()
}

fn main(){
    let my_float = get_next_float();
}