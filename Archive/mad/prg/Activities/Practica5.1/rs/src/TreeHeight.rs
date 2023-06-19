// Tree height in Rust
use std::io;

// Struct designed to read ints on a line
struct IntReader{
	pos : u32,
	nums : Vec<u32>,
}

impl IntReader{
	// Constructor
	fn new() -> IntReader{
		return IntReader{
			pos : 0,
			nums : Vec::<u32>::new(),
		};
	}

	// Picks the enxt int of the strip
	fn next_int(&mut self) -> i32{
		// Reset the input if needed
		if self.pos >= (self.nums.len() as u32){
			self.pos = 0;
			let mut str = String::new();
			let _rs = io::stdin().read_line(&mut str);

			let trimmed_str = str.trim();
			let mut size:u32 = 0;
			// First rep
			for c in trimmed_str.chars(){
				if c == ' ' {size += 1;}
			}
			size += 1;
			
			let mut i:u32 = 0;
			self.nums.clear();
			self.nums.resize(size as usize, 0);
			// Second rep
			for c in trimmed_str.chars(){
				if c != ' '{
					self.nums[i as usize] *= 10;
					self.nums[i as usize] += c.to_digit(10).unwrap();
				}
				else{
					i += 1;
				}
			}
		}

		// Increase the input
		let n:u32 = self.nums[self.pos as usize];
		self.pos += 1;

		// Return next input
		n as i32
	}
}

// Branch struct that calculates the height of the tree recursively
struct Branch{

}

impl Branch{
	// Basic branch constructor
	fn new() -> Branch{
		return Branch{};
	}

	// Calculate height of the branch
	fn calculate_height(&self, input: &mut IntReader) -> i32{
		let branch_number = input.next_int();
		let branch = Branch::new();
		let mut max_height = 0;
		for _i in 0..branch_number{
			let height = branch.calculate_height(input);
			if height > max_height {max_height = height;}
		}
		max_height + 1
	}
}

// Main function, initializes the number of cases and the root
fn main(){
	let mut input = IntReader::new();
	let cases = input.next_int();
	let root = Branch::new();
	for _i in 0..cases{
		println!("{}", root.calculate_height(&mut input));
	}
}
